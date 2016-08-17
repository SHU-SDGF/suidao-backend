# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20160817150208) do

  create_table "act_statuses", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "name"
    t.string   "order"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "act_types", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "name"
    t.string   "order"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "authorities", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "name"
    t.integer  "order"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "defect_locations", id: false, force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "DISEASE_NO", limit: 30,                null: false
    t.string   "MILEAGE"
    t.decimal  "TwoD_X",                precision: 10
    t.decimal  "TwoD_Y",                precision: 10
    t.decimal  "ThreeD_X",              precision: 10
    t.decimal  "ThreeD_Y",              precision: 10
    t.decimal  "ThreeD_Z",              precision: 10
    t.datetime "created_at",                           null: false
    t.datetime "updated_at",                           null: false
  end

  create_table "detail_types", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "name"
    t.string   "order"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "direction_informations", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "name"
    t.string   "order"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "disease_types", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "name"
    t.string   "order"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "environment_actitivity_summaries", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "ACT_NO"
    t.string   "ACT_NAME"
    t.datetime "START_DATE"
    t.string   "Surround_NO"
    t.text     "TAD_ID",      limit: 65535
    t.datetime "END_DATE"
    t.text     "DESCRIPTION", limit: 65535
    t.string   "ACT_LEVEL"
    t.decimal  "LONGTITUDE",                precision: 10
    t.decimal  "LATITUDE",                  precision: 10
    t.integer  "SynChronize"
    t.integer  "user_id"
    t.integer  "DEL_FLG"
    t.integer  "UDPATE_CNT"
    t.string   "CREATE_USER"
    t.string   "UPDATE_USER"
    t.datetime "created_at",                               null: false
    t.datetime "updated_at",                               null: false
  end

  create_table "environment_activities", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "ACT_NO"
    t.datetime "INSP_DATE"
    t.string   "ACT_TYPE"
    t.string   "ACT_STATUS"
    t.text     "Description", limit: 65535
    t.string   "Photo"
    t.string   "Audio"
    t.string   "VIDEO"
    t.string   "Recorder"
    t.integer  "user_id"
    t.boolean  "SynChronize"
    t.boolean  "DEL_FLG"
    t.string   "UPDATE_CNT"
    t.string   "CREATE_USER"
    t.string   "UPDATE_USER"
    t.datetime "created_at",                null: false
    t.datetime "updated_at",                null: false
  end

  create_table "facilities", id: false, force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "FACILITY_NO",                 limit: 30,    null: false
    t.string   "FACILITY_NAME"
    t.string   "FACILITY_IMPORTANCE"
    t.text     "SUPPLEMENTARY_SPECIFICATION", limit: 65535
    t.datetime "COMPLETE_DATE"
    t.text     "CONTINGENCY_PLAN",            limit: 65535
    t.text     "TECHNICAL_INDEX",             limit: 65535
    t.text     "SUBSIDY_DOCUMENT",            limit: 65535
    t.string   "MODEL_EXIST"
    t.text     "REMARK",                      limit: 65535
    t.integer  "DEL_FLG"
    t.integer  "UPDATE_CNT"
    t.string   "CREATE_USER"
    t.string   "UPDATE_USER"
    t.datetime "created_at",                                null: false
    t.datetime "updated_at",                                null: false
  end

  create_table "facility_details", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "DISEASE_NO"
    t.datetime "DISEASE_DATE"
    t.string   "MONOMER_NO"
    t.string   "FACILITY_NO"
    t.string   "FACILITY_TYPE"
    t.string   "MILEAGE"
    t.string   "DIRECTION_INFORMATION"
    t.text     "TAG_ID",                limit: 65535
    t.string   "MODEL_NAME"
    t.integer  "user_id"
    t.string   "DISEASE_DISCRIPTION"
    t.string   "DISEASE_TYPE"
    t.decimal  "AREA",                                precision: 10
    t.decimal  "DEPTH",                               precision: 10
    t.decimal  "LENGTH",                              precision: 10
    t.decimal  "WIDTH",                               precision: 10
    t.decimal  "VOLUMN",                              precision: 10
    t.string   "LEAKAGE_LEVEL"
    t.decimal  "DROP_SPEED",                          precision: 10
    t.decimal  "DRIP_SPEED",                          precision: 10
    t.decimal  "LINELEAK_SPEED",                      precision: 10
    t.decimal  "MUDLEAK_SPEED",                       precision: 10
    t.string   "PHOTO"
    t.string   "RECORDER"
    t.integer  "DEL_FLG"
    t.integer  "UPDATE_CNT"
    t.string   "CREATE_USER"
    t.string   "UPDATE_USER"
    t.float    "JOINTOPEN",             limit: 24
    t.float    "DISLOCATION",           limit: 24
    t.string   "Pos_Desp"
    t.datetime "created_at",                                         null: false
    t.datetime "updated_at",                                         null: false
  end

  create_table "facility_maintenances", id: false, force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "FM_NO",          limit: 30,                null: false
    t.string   "DISEASE_NO"
    t.string   "REPAIR_CONTENT"
    t.integer  "REPAIR_AMOUNT"
    t.string   "QUOTA_NO"
    t.decimal  "REPAIR_FEE",                precision: 10
    t.datetime "FINISH_DATE"
    t.integer  "user_id"
    t.integer  "DEL_FLG"
    t.integer  "UPDATE_CNT"
    t.string   "CREATE_USER"
    t.string   "UPDATE_USER"
    t.datetime "created_at",                               null: false
    t.datetime "updated_at",                               null: false
  end

  create_table "monomers", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "name"
    t.string   "order"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "position_descriptions", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "name"
    t.string   "order"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "users", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string   "name"
    t.string   "email"
    t.string   "password_digest"
    t.integer  "Authority"
    t.datetime "created_at",      null: false
    t.datetime "updated_at",      null: false
  end

end
