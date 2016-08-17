class InspectionController < ApplicationController
  def getInspectionList
    inspections = Monomer.all.map do |inspection|
       new_inspection = { id: inspection.id, name: inspection.name, order: inspection.order}
    end
    render json: {result: inspections}
  end
end