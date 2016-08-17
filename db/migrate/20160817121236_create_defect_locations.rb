class CreateDefectLocations < ActiveRecord::Migration[5.0]
  def change
    create_table :defect_locations, :id => false do |t|
      t.string :DISEASE_NO, limit: 30, primary: true, null:false
      t.string :MILEAGE
      t.decimal :TwoD_X
      t.decimal :TwoD_Y
      t.decimal :ThreeD_X
      t.decimal :ThreeD_Y
      t.decimal :ThreeD_Z

      t.timestamps
    end
  end
end
