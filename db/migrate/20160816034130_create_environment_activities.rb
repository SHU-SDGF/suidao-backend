class CreateEnvironmentActivities < ActiveRecord::Migration[5.0]
  def change
    create_table :environment_activities do |t|
      t.string :ACT_NO
      t.datetime :INSP_DATE
      t.string :ACT_TYPE
      t.string :ACT_STATUS
      t.text :Description
      t.string :Photo
      t.string :Audio
      t.string :VIDEO
      t.string :Recorder
      t.integer :user_id
      t.boolean :SynChronize
      t.boolean :DEL_FLG
      t.string :UPDATE_CNT
      t.string :CREATE_USER
      t.string :UPDATE_USER

      t.timestamps
    end
  end
end
