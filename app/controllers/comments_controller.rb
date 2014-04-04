class CommentsController < ApplicationController
	before_action :signed_in_user

	def create
		@comment =  Comment.new comment_params
		if @comment.save
			flash[:success] = "Added your comment."
		else 
			flash[:fail] = "Comment fail!"
		end
		redirect_to :back
	end

	def destroy
		@comment = Comment.find params[:id]
		@comment.destroy
		redirect_to :back
	end

	private

		def comment_params
			params.require(:comment).permit(:entry_id, :content, :user_id)
		end
end