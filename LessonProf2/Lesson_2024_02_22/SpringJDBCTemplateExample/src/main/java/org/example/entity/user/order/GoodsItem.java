package org.example.entity.user.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.user.Comment;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "goods_items")
public class GoodsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany(mappedBy = "items")
    private Set<Order> orders = new HashSet<>();

    @OneToMany(mappedBy = "goodsItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    public void addComment(Comment comment){
        comments.add(comment);
        comment.setGoodsItem(this);
    }

    public void deleteComment(Comment comment){
        comments.remove(comment);
        comment.setGoodsItem(null);
    }
}
