class CreatePositionDescriptions < ActiveRecord::Migration[5.0]
  def change
    create_table :position_descriptions do |t|
      t.string :name
      t.string :order

      t.timestamps
    end
  end
end
