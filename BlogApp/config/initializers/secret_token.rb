# Be sure to restart your server when you modify this file.

# Your secret key is used for verifying the integrity of signed cookies.
# If you change this key, all old signed cookies will become invalid!

# Make sure the secret is at least 30 characters and all random,
# no regular words or you'll be exposed to dictionary attacks.
# You can use `rake secret` to generate a secure secret key.

# Make sure your secret_key_base is kept private
# if you're sharing your code publicly.
require 'securerandom'

def secure_token
	token_file = Rails.root.join('.secret')
	if File.exist?(token_file)
		File.read(token_file).chomp
	else
		token = SecureRandom.hex(64)
		File.write(token_file, token)
		token
	end
end

BlogApp::Application.config.secret_key_base = secure_token
#SampleApp::Application.config.secret_key_base = 'c337b09b0cc17ae2614650a7111c9c5813bf008bdca89a8c623f835133733ac9ef04268422c59665a3fab51eed238de914e8a5d13359eb4b272a7ceb5f11ea99'
