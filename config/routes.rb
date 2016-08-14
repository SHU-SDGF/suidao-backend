Rails.application.routes.draw do
  scope '/api' do
    post 'login' => 'auth#authenticate', module: 'api'
  end
end
