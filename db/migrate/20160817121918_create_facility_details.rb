class CreateFacilityDetails < ActiveRecord::Migration[5.0]
  def change
    create_table :facility_details do |t|
      t.string :DISEASE_NO
      t.datetime :DISEASE_DATE
      t.string :MONOMER_NO
      t.string :FACILITY_NO
      t.string :FACILITY_TYPE
      t.string :MILEAGE
      t.string :DIRECTION_INFORMATION
      t.text :TAG_ID
      t.string :MODEL_NAME
      t.integer :user_id
      t.string :DISEASE_DISCRIPTION
      t.string :DISEASE_TYPE
      t.decimal :AREA
      t.decimal :DEPTH
      t.decimal :LENGTH
      t.decimal :WIDTH
      t.decimal :VOLUMN
      t.string :LEAKAGE_LEVEL
      t.decimal :DROP_SPEED
      t.decimal :DRIP_SPEED
      t.decimal :LINELEAK_SPEED
      t.decimal :MUDLEAK_SPEED
      t.string :PHOTO
      t.string :RECORDER
      t.integer :DEL_FLG
      t.integer :UPDATE_CNT
      t.string :CREATE_USER
      t.string :UPDATE_USER
      t.float :JOINTOPEN
      t.float :DISLOCATION
      t.string :Pos_Desp

      t.timestamps
    end
  end
end
