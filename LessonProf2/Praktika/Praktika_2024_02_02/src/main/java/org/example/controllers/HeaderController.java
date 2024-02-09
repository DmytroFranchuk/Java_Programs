package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
public class HeaderController {
    @GetMapping("/headers")
    public ResponseEntity<?> headerReturn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> headers = new HashMap<>();
        Iterator<String> iner = request.getHeaderNames().asIterator();
        iner.forEachRemaining(hname -> headers.put(hname, request.getHeader(hname)));
        if (headers.size() < 3) {
            response.sendError(400, "need more headers");
            return ResponseEntity.badRequest().body("need more headers");
        }
        if ("true".equals(headers.get("x-error-result"))) {
            response.sendError(500, "get your error");
            return ResponseEntity.badRequest().body("get your error");
        }
        String redirectPath = headers.get("x-forward-path");
        if (redirectPath != null && !redirectPath.isBlank()) {
            response.sendRedirect(redirectPath);
            return null;
        }
        return ResponseEntity.ok(headers.toString());
    }
}
