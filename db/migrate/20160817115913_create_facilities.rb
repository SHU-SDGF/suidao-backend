class CreateFacilities < ActiveRecord::Migration[5.0]
  def change
    create_table :facilities, :id => false do |t|
      t.string :FACILITY_NO, limit: 30, primary: true, null: false
      t.string :FACILITY_NAME
      t.string :FACILITY_IMPORTANCE
      t.text :SUPPLEMENTARY_SPECIFICATION
      t.datetime :COMPLETE_DATE
      t.text :CONTINGENCY_PLAN
      t.text :TECHNICAL_INDEX
      t.text :SUBSIDY_DOCUMENT
      t.string :MODEL_EXIST
      t.text :REMARK
      t.integer :DEL_FLG
      t.integer :UPDATE_CNT
      t.string :CREATE_USER
      t.string :UPDATE_USER

      t.timestamps
    end
  end
end
