db.txs.aggregate();

// Вывести две случайных eur-транзакции

db.txs.aggregate([
    { $match: { currency: { $regex: /^EUR$/i } } },
    { $sample: { size: 2 } }
]);


// Вывести юзеров, которые не отправляли средства (не делали транзакции)





