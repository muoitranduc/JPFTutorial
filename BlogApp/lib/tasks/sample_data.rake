namespace :db do
	desc "Fill database with sample data"
	task populate: :environment do
		make_users
		make_entries
		make_comments
		make_relationships
	end
end

def make_users
	admin = User.create!(name: "Example User",
					email: "example@railstutorial.com",
					password: "foobar",
					password_confirmation: "foobar",
					admin: true )
	99.times do |n|
		name = Faker::Name.name
		email = "example-#{n+1}@railstutorial.org"
		password = "password"
		User.create!(name: name,
						email: email,
						password: password,
						password_confirmation: password)
	end
end

def make_entries
	users = User.all(limit: 6)
	50.times do
		content = Faker::Lorem.sentence(5)
		title = Faker::Lorem.sentence(1)
		users.each { |user| user.entries.create!(title: title, content: content)}
	end
end

def make_comments
	users = User.all(limit: 6)
	entries = Entry.all(limit: 5)
	5.times do
		content = Faker::Lorem.sentence(5)
		users.each do |user|
			entries.each do |entry|
				entry.comments.create!(content: content, user_id: user.id)
			end
		end
	end
end


def make_relationships
	users = User.all
	user = users.first
	followed_users = users[2..50]
	followers = users[3..40]
	followed_users.each { |followed| user.follow!(followed)}
	followers.each { |follower| follower.follow!(user)}
end