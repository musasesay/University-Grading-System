package controllers;

import java.awt.Dialog.ModalityType;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import models.LoggedData;
import models.Task;
import views.ClassHomePage;
import views.TaskDialog;

public class TaskDialogController {

	private TaskDialog dialog; 
	private ClassHomePage classHomePage;
	private int TaskId; // 0 means creating new task


	public TaskDialogController(ClassHomePage c)
	{

		this(c, 0);
		//dialog.getDeleteButton().setVisible(false);
		//System.out.println("hide");
	}

	public TaskDialogController(ClassHomePage c, int id)
	{
		System.out.println("with id ");
		TaskId = id;
		classHomePage = c;
		try {
			dialog = new TaskDialog();
			if (TaskId == 0)
			{
				dialog.getDeleteButton().setVisible(false);
			}
			initController();
			dialog.setModalityType(ModalityType.APPLICATION_MODAL);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(classHomePage);
			dialog.setVisible(true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	private void initController()
	{
		BindData();
		dialog.getSaveButton().addActionListener(l -> SaveTask());
		dialog.getCancelButton().addActionListener(l -> Close());
		dialog.getDeleteButton().addActionListener(l -> DeleteTask());

	}

	private void BindData()
	{
		System.out.println("Bind Data" + TaskId);
		if (TaskId != 0)
		{
			dialog.setNameTf(LoggedData.getSelectedTask().getName());
			dialog.setWeightTf(Float. toString(LoggedData.getSelectedTask().getWeightInFinalGrade()));
		}
	}

	private void SaveTask()
	{
		var taskList = LoggedData.getSelectedCourse().getTasks();
		if (TaskId != 0)
		{
			for (var t : taskList)
			{
				if (t.getId() == TaskId)
				{
					t.setName(dialog.getNameTf().getText());
					t.setWeightInFinalGrade(Float.parseFloat(dialog.getWeightTf().getText()));
					break;
				}
			}
		}
		else
		{
			Task task = new Task(0, dialog.getNameTf().getText(), Float.parseFloat(dialog.getWeightTf().getText()));
			LoggedData.getSelectedCourse().getTasks().add(task);		
		}
		UpdateTaskTable(LoggedData.getSelectedCourse().getTasks());
		Close();
	}

	private void Close()
	{
		dialog.dispose();
	}
	private void DeleteTask()
	{
		if (TaskId != 0)
		{
			var taskList = LoggedData.getSelectedCourse().getTasks();

			for (var t : taskList)
			{
				if (t.getId() == TaskId)
				{
					taskList.remove(t);
					break;
				}
			}
			UpdateTaskTable(taskList);

			LoggedData.setSelectedTask(null);
			LoggedData.setSelectedSubTask(null);
		}
		Close();
	}

	private void UpdateTaskTable(ArrayList<Task> taskList)
	{
		String col[] = {"Id","Task Name","Edit",};
		TableModel tableModel = new DefaultTableModel(col, 0);

		if (taskList != null)
		{
			System.out.println(taskList.size());
			for (int i = 0; i < taskList.size(); i++)
			{
				Object[] objs = {taskList.get(i).getId(), taskList.get(i).getName(),
				"Edit"};
				((DefaultTableModel) tableModel).addRow(objs);
			}	
		}
		classHomePage.setTaskTable(tableModel);
	}
}
