# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)
if(!User.any?)
  user = User.create({ name: 'admin', email: 'admin@gmail.com', password: 'admin', password_confirmation: 'admin'})
end

if(!ActType.any?)  
  act_types = ActType.create([{name:"加载", order:1},{name:"减载", order: 2},{name: "振动", order: 3},{name:"静载", order: 4}, {name: "其他", order: 5}])
end

if(!ActStatus.any?)
  act_status = ActStatus.create([{name:"未开始", order: 0}, {name: "进行中", order: 1}, {name: "已结束", order: 2}])
end

