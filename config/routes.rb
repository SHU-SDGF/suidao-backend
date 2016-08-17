Rails.application.routes.draw do
  scope '/api' do
    post 'login' => 'auth#authenticate', module: 'api'
    post 'user/validate' => 'auth#validate', module: 'api'
    resources :users, only: [:index]
  end
end
