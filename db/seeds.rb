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
  act_types = ActType.create([{name:"加载", order:"1"},{name:"减载", order: "2"},{name: "振动", order: "3"},{name:"静载", order: "4"}, {name: "其他", order: "5"}])
end

if(!ActStatus.any?)
  act_status = ActStatus.create([{name:"未开始", order: "0"}, {name: "进行中", order: "1"}, {name: "已结束", order: "2"}])
end

if(!Authority.any?)
  authorities = Authority.create([{name: "资产数据采集", order: "1"}, {name: "展示访客", order: "2"}, {name: "技术人员", order: "3"}, {name: "访客", order: "4"}, {name: "系统管理人员", order: "5"},{name: "中控巡检管理", order: "6"},{name: "中控巡检采集", order: "7"},{name: "运营管理", order: "8"}])
end

if(!PositionDescription.any?)
  positionDescriptions = PositionDescription.create([{name: "环缝", order: "1"},{name: "片缝", order: "2"},{name: "裂缝", order: "3"},{name: "注浆孔", order: "4"},{name: "螺栓孔", order: "5"},{name: "螺栓", order: "6"}])
end

if(!DiseaseType.any?)
  diseaseTypes = DiseaseType.create([{name: "裂缝",order: "1"}, {name: "渗漏", order: "2"},{name: "缺损", order: "3"}, {name:"错台", order: "4"},{name: "张开", order: "5"},{name: "腐蚀", order: "6"}])
end

if(!DetailType.any?)
  detailTypes = DetailType.create([{name: "细微裂纹", order: "1"},{name: "径向裂缝", order: "2"},{name: "纵向裂缝", order: "3"},{name: "横向裂缝", order: "4"},{name: "竖向裂纹", order: "5"},{name: "湿渍", order: "6"},{name: "渗水", order: "7"},{name: "水珠", order: "8"},{name: "滴漏", order: "9"},{name: "线漏", order: "10"},{name: "漏泥沙", order: "11"},{name: "缺角", order: "12"},{name: "止水带损坏", order: "13"},{name: "螺栓损坏", order: "14"},{name: "环间错台", order:"15"},{name: "环内错台",order: "16"},{name: "变形缝张开",order: "17"},{name: "裂缝张开", order: "18"},{name: "起壳", order: "19"},{name: "锈斑", order: "20"},{name: "泌出", order: "21"},{name: "起皮", order: "22"},{name: "起层", order: "23"},{name: "蜂窝", order: "24"},{name: "麻面",order:"25"},{name: "松花", order: "26"},{name: "凸起", order: "27"},{name: "剥落", order: "28"},{name: "凹陷", order: "29"},{name: "掉粉", order: "30"}])
end

if(!DirectionInformation.any?)
  directioninformations = DirectionInformation.create([{name: "东侧", order: "1"},{name: "西侧", order: "2"},{name: "不区分", order: "0"}])
end

if(!Monomer.any?)
  monomers = Monomer.create([{name: "东线隧道", order: "1"},{name: "西线隧道", order: "2"},{name: "浦东工作井", order: "3"},{name: "浦西工作井", order: "4"}, {name: "1#联络通道", order: "5"}, {name: "2#联络通道", order: "6"},{name: "隧道管理大楼", order: "7"},{name: "矩形段安全通道", order: "8"},{name: "矩形段电缆通道", order: "9"},{name: "保护区", order: "A"},{name: "浦东龙门架", order: "B"},{name: "浦西龙门架", order: "C"}])
end