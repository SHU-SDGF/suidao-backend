class ApplicationController < ActionController::API
  before_action :set_current_user, :authenticated_request

  private

  def set_current_user
    if decoded_auth_token
      @current_user ||= User.find(decoded_auth_token[:user_id])
    end
  end

  def authenticated_request
    if !@current_user
      render json: { error: 'Not Authorized'}, status: 401 
    elsif auth_token_expired?
      render json: { error: 'Auth token is expired' }, status: 419
    end
  end

  def decoded_auth_token
    @decoded_auth_token ||= AuthToken.decode(http_auth_header_content)
  end

  def auth_token_expired?
    decoded_auth_token && decoded_auth_token.expired
  end

  def http_auth_header_content
    return @http_auth_header_content if defined? @http_auth_header_content
    @http_auth_header_content = begin
      if request.headers['Authorization'].present?
        request.headers['Authorization'].split(' ').last
      else
        nil
      end      
    end
  end
end
