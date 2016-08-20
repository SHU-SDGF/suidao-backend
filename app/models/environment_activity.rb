# 环境活动历史表
class EnvironmentActivity < ApplicationRecord
  belongs_to :user
  belongs_to :environment_activity_summary, foreign_key: 'ACT_NO'
end
