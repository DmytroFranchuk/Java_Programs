// Вывести реакции с оценкой до 4 (вкл.)
db.reactions.find({value: {$lte: 4}});

// Вывести ко-во незаблокированных юзеров
db.users.countDocuments({is_blocked: {$ne: true}});

// Добавить произвольный email юзеру 1
db.users.updateOne(
   { _id: 1 },
   { $set: { email: "email@gmail.com" } }
);

// Поменять страну юзера 2 на 'Brazil'
db.users.updateOne(
   { _id: 2 },
   { $set: { country: "Brazil" } }
);

// Заблокировать юзеров 1 и 5
db.users.updateMany(
    { _id: {$in: [1, 5]} },
    {
        $set: {
            is_blocked: true
        }
    }
);

// Разблокировать всех юзеров
db.users.updateMany(
    { },
    {
        $set: {
            is_blocked: false
        }
    }
);

// Вывести ко-во незаблокированных юзеров из Germany
db.users.countDocuments({is_blocked: {$eq: false},country: "Germany"})



