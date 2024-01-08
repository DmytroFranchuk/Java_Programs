// Вывести имена юзеров не из France
db.users.find({country: {$ne: "France"}});
// Добавить поле reactions в каждый документ коллекции tracks
db.tracks.updateMany({}, { $set: { reactions:[] } } )
// Добавить реакции для определенного трека формате user_id : reaction {like, dislike, love}
db.tracks.updateOne(
    { _id: 1 },
    { $push: { reactions: { user_id: 1, reaction: 'like' } } }
)

db.tracks.updateOne(
    { _id: 2 },
    { $push: { reactions: { user_id: 1, reaction: 'love' } } }
)

db.tracks.updateOne(
    { _id: 3 },
    { $push: { reactions: { user_id: 1, reaction: 'dislike' } } }
)
// Возвращает все документы из коллекции tracks без каких-либо фильтров или дополнительных параметров:
db.tracks.find()
// Вывести названия треков продолжительностью от 1 до 10 мин
db.tracks.find({
  duration_secs: {
    $gte: 60,
    $lte: 600
  }
}, { title: 1, _id: 0 })
// Вывести треки юзера 4
// Добавим пустой массив tracks для всех пользователей
db.users.updateMany(
  {},
  { $set: { tracks: [] } }
)

// Добавим номера треков в поле tracks для пользователя с _id = 4
db.users.updateOne(
  { _id: 5 },
  { $addToSet: { tracks: { $each: [3, 4, 5] } } }
)

// Вывести все треки пользователя 4
db.users.findOne({ _id: 4 }, { tracks: 1, _id: 0 })

