// вывести две случайных eur-транзакции
db.txs.aggregate([
    { $match: { currency: /eur/i } },
    { $sample: { size: 2 } }
]);

// вывести юзеров, которые не отправляли средства (не делали транзакции)
db.clients.aggregate([
    {
        $lookup: {
            from: 'txs',
            localField: '_id',
            foreignField: 'sender_id',
            as: 'sender'
        }
    },
    {
        $match: {
            sender: { $size: 0 }
        }
    }
]);

// вывести сумму отправленных EUR-транзакций для каждого юзера
db.txs.aggregate([
    { $match: { currency: /eur/i } },
    {
        $lookup: {
            from: 'clients',
            localField: 'sender_id',
            foreignField: '_id',
            as: 'sender'
        }
    },
    { $unwind: '$sender' },
    {
        $group: {
            _id: '$sender.fullname',
            total_sum: { $sum: '$amount' }
        }
    }
])


