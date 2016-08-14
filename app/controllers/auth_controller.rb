class AuthController < ApplicationController
  skip_before_action :authenticated_request

  def authenticate
    user = User.find_by_credentials(params[:username], params[:password])
    if user
      render json: { auth_token: user.generate_auth_token, user: {name: user.name} }
    else 
      render json: { error: 'Invalid username or password'}, status: :unauthorized
    end
  end
end