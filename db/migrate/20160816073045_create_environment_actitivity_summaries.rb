class CreateEnvironmentActitivitySummaries < ActiveRecord::Migration[5.0]
  def change
    create_table :environment_actitivity_summaries do |t|
      t.string :ACT_NO
      t.string :ACT_NAME
      t.datetime :START_DATE
      t.string :Surround_NO
      t.text :TAD_ID
      t.datetime :END_DATE
      t.text :DESCRIPTION
      t.string :ACT_LEVEL
      t.decimal :LONGTITUDE
      t.decimal :LATITUDE
      t.integer :SynChronize
      t.integer :user_id
      t.integer :DEL_FLG
      t.integer :UDPATE_CNT
      t.string :CREATE_USER
      t.string :UPDATE_USER

      t.timestamps
    end
  end
end
