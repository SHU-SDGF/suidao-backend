#病害类型枚举表
class DiseaseType < ApplicationRecord
  has_many :detail_types
end
