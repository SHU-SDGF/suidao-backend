class User < ApplicationRecord
  has_secure_password

  def self.find_by_credentials(username, password)
    user = User.find_by(name: username)
    user ? user.authenticate(password) : nil
  end

  def generate_auth_token
    payload = { user_id: self.id }
    AuthToken.encode(payload)
  end
end
