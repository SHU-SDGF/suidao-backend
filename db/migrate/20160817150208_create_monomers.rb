class CreateMonomers < ActiveRecord::Migration[5.0]
  def change
    create_table :monomers do |t|
      t.string :name
      t.string :order

      t.timestamps
    end
  end
end
