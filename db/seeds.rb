# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)
if(!User.any?)
  user = User.create({ name: 'admin', email: 'admin@gmail.com', password: 'admin', password_confirmation: 'admin'})
  user = User.create({name: 'admin1', email: 'admin1@gmail.com', password: 'admin1', password_confirmation: 'admin1'})
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
  detailTypes = DetailType.create([{name: "细微裂纹", order: "1", disease_type_id: 1},{name: "径向裂缝", order: "2", disease_type_id: 1},{name: "纵向裂缝", order: "3", disease_type_id: 1},{name: "横向裂缝", order: "4", disease_type_id: 1},{name: "竖向裂纹", order: "5", disease_type_id: 1},{name: "湿渍", order: "6", disease_type_id: 2},{name: "渗水", order: "7", disease_type_id: 2},{name: "水珠", order: "8", disease_type_id: 2},{name: "滴漏", order: "9", disease_type_id: 2},{name: "线漏", order: "10", disease_type_id: 2},{name: "漏泥沙", order: "11", disease_type_id: 2},{name: "缺角", order: "12", disease_type_id: 3},{name: "止水带损坏", order: "13", disease_type_id: 3},{name: "螺栓损坏", order: "14", disease_type_id: 3},{name: "环间错台", order:"15", disease_type_id: 4},{name: "环内错台",order: "16", disease_type_id: 4},{name: "变形缝张开",order: "17", disease_type_id: 5},{name: "裂缝张开", order: "18", disease_type_id: 5},{name: "起壳", order: "19",disease_type_id: 6},{name: "锈斑", order: "20", disease_type_id: 6},{name: "泌出", order: "21", disease_type_id: 6},{name: "起皮", order: "22", disease_type_id: 6},{name: "起层", order: "23", disease_type_id: 6},{name: "蜂窝", order: "24", disease_type_id: 6},{name: "麻面",order:"25", disease_type_id: 6},{name: "松花", order: "26", disease_type_id: 6},{name: "凸起", order: "27", disease_type_id: 6},{name: "剥落", order: "28", disease_type_id: 6},{name: "凹陷", order: "29", disease_type_id: 6},{name: "掉粉", order: "30", disease_type_id: 6}])
end

if(!DirectionInformation.any?)
  directioninformations = DirectionInformation.create([{name: "东侧", order: "1"},{name: "西侧", order: "2"},{name: "不区分", order: "0"}])
end

if(!Monomer.any?)
  monomers = Monomer.create([{name: "东线隧道", order: "1"},{name: "西线隧道", order: "2"},{name: "浦东工作井", order: "3"},{name: "浦西工作井", order: "4"}, {name: "1#联络通道", order: "5"}, {name: "2#联络通道", order: "6"},{name: "隧道管理大楼", order: "7"},{name: "矩形段安全通道", order: "8"},{name: "矩形段电缆通道", order: "9"},{name: "保护区", order: "A"},{name: "浦东龙门架", order: "B"},{name: "浦西龙门架", order: "C"}])
end

if(!EnvironmentActivitySummary.any?)
  eas = EnvironmentActivitySummary.create(ACT_NO: "2015040101", ACT_NAME: "东线隧道日常巡检", START_DATE: "4/1/15 0:00", Surround_NO: "HDLL100SZ000K00000_000", ACT_LEVEL: 0, LONGTITUDE: '', LATITUDE: '', CREATE_USER: '', UPDATE_USER: 'TUNNELDL')
end

if(!EnvironmentActivity.any?) 
  EnvironmentActivity.create(ACT_NO: '2015040101', INSP_DATE: '5/26/15 0:00', ACT_TYPE: '2', ACT_STATUS: '1', Description: '建发大厦正在建造', Recorder: '吴心刚', CREATE_USER: 'TUNNELDL', UPDATE_USER: 'TUNNELDL')
  EnvironmentActivity.create(ACT_NO: '2015040101', INSP_DATE: '6/26/15 0:00', ACT_TYPE: '1', ACT_STATUS: '0', Description: '建发大厦开始建造', Recorder: '吴心刚', CREATE_USER: 'TUNNELDL', UPDATE_USER: 'TUNNELDL')
end