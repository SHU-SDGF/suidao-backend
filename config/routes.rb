Rails.application.routes.draw do
  scope '/api' do
    post 'login' => 'auth#authenticate', module: 'api'
    post 'user/validate' => 'auth#validate', module: 'api'
    get 'inspections' => 'inspection#getInspectionList', module: 'api'
    resources :users, only: [:index]
    resources :environment_activities
  end
end
