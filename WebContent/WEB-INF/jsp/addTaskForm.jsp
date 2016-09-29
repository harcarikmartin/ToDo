<h4>Add a new task</h4>
<form method="post">
	<div>
		<input type="text" name="taskName" placeholder="Name of my task"></input><br>
		<textarea name="taskBody" placeholder="Body of my task" cols="30" rows="8" draggable="false"></textarea><br>
		<input type="hidden" name="action" value="addTask"></input>
		<input type="submit" value="Add Task"></input>
	</div>
</form>