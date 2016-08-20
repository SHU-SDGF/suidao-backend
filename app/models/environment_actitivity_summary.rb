# 环境活动汇总表
class EnvironmentActitivitySummary < ApplicationRecord
  belongs_to :user
  has_many :environment_actitivities
end
