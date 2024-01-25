// Увеличить баланс всех незаблокированных юзеров не из China на 200 EUR

db.users.updateMany(
    {is_blocked: {$ne: true}, country: {$ne: 'China'}}, 
    {$inc: {balance: 200}}
    );
    
// Уменьшить баланс на 25 EUR всех юзеров c балансом от 100 EUR

db.users.updateMany(
    {balance: {$gte: 100}}, 
    {$inc: {balance: -25}}
    );
    
// Уменьшить баланс всех юзеров на 0.5%

db.users.updateMany(
    {}, 
    {$mul: {balance: 0.995}}
    );

// Добавить всем трекам теги a и b

db.tracks.updateMany(
    {}, 
    { $addToSet: { tags: { $each: ['a', 'b'] } } }
    );
    
    
// Вывести ко-во треков с тегом a

db.tracks.countDocuments({tags: 'a'});



db.tracks.updateMany(
    {},
    { $addToSet: { tags: 'test' } }
    );



// Удалить тег test у всех треков

db.tracks.updateMany(
    {},
    { $pull: { tags: 'test' } }
    );


db.users.find();
db.tracks.find();




