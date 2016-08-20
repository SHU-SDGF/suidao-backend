class EnvironmentActivitiesController < ApplicationController
  def index

  end

  def latest_environment_activity
    
  end

  def environment_activity_list
    @envirnmentActivity
    @environemnt_activity_list = EnvironemntActivity.find(params["id"])
  end

  def create
    # byebug
    @environment_activity_summary = EnvironmentActivitySummary.new(ACT_NO: params["act_no"], ACT_NAME: params["act_name"], START_DATE: params["start_date"], Surround_No: params["surround_no"], 
                                                                   TAG_ID: params["tag_id"], END_DATE: params["end_date"], DESCRIPTION: params["description"], ACT_LEVEL: params["act_level"], 
                                                                   LONGTITUDE: params["longtitude"], LATITUDE: params["latitude"], SynChronize: 0, DEL_FLG: 0, UPDATE_CNT: 0, user_id: @current_user.id, CREATE_USER: @current_user, UPDATE_USER: '')
    @environment_activity = EnvironemntActivity.new(ACT_NO: params["act_no"], INSP_DATE: params["insp_date"], ACT_TYPE: params[:act_type], ACT_STATUS: params["act_status"], Description: params["description"],
                                                    Photo: params["photo"], Audio: params["audio"], VIDEO: params["video"], Recorder: params["recorder"], Synchronize: 0, DEL_FLG: 0, UPDATE_CNT: 0,
                                                    CREATE_USER: params["create_user"], UPDATE_USER: '')
    if @environment_activity_summary.save and @environment_activity.save
      render json: @environment_activity, status: :created
    else
      render json: {"result": "created failed!"}, status: :unprocessable_entity
    end
  end

  def update
    @environment_activity_summary = EnvironmentActivitySummary.find(params[:id])

    if @environment_activity_summary.update(ACT_NO: params["act_no"], ACT_NAME: params["act_name"], START_DATE: params["start_date"], Surround_No: params["surround_no"], 
                                                                   TAG_ID: params["tag_id"], END_DATE: params["end_date"], DESCRIPTION: params["description"], ACT_LEVEL: params["act_level"], 
                                                                   LONGTITUDE: params["longtitude"], LATITUDE: params["latitude"], UPDATE_CNT: @environment_activity_summary["UPDATE_CNT"] + 1, UPDATE_USER: params["update_user"])
       and @environment_activity = EnvironemntActivity.new(ACT_NO: params["act_no"], INSP_DATE: params["insp_date"], ACT_TYPE: params[:act_type], ACT_STATUS: params["act_status"], Description: params["description"],
                                                    Photo: params["photo"], Audio: params["audio"], VIDEO: params["video"], Recorder: params["recorder"], Synchronize: 0, DEL_FLG: 0, UPDATE_CNT: 0,
                                                    CREATE_USER: params["update_user"], UPDATE_USER: '')

       render json: @environment_activity_summary, status: :created
    else
      render json: {"result": "update failed!"}, status: :unprocessable_entity
    end
  end

  def show
  end
end
