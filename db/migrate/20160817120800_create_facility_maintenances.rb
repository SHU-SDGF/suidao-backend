class CreateFacilityMaintenances < ActiveRecord::Migration[5.0]
  def change
    create_table :facility_maintenances, :id => false do |t|
      t.string :FM_NO, limit: 30, primary: true, null:false
      t.string :DISEASE_NO
      t.string :REPAIR_CONTENT
      t.integer :REPAIR_AMOUNT
      t.string :QUOTA_NO
      t.decimal :REPAIR_FEE
      t.datetime :FINISH_DATE
      t.integer :user_id
      t.integer :DEL_FLG
      t.integer :UPDATE_CNT
      t.string :CREATE_USER
      t.string :UPDATE_USER

      t.timestamps
    end
  end
end
