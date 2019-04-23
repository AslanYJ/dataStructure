package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先队列Demo
 * @author lanyangjia
 */
public class PriorityQueueDemo {
    //WorkGroup比较器
    private static class WorkGroupComparator implements Comparator<WorkGroupTask> {
        @Override
        public int compare(WorkGroupTask o1, WorkGroupTask o2) {
            if(o1.getTaskNum() > o2.getTaskNum()) {
                return 1;
            } else if(o1.getTaskNum() < o2.getTaskNum()) {
                return -1;
            }
            return 0;
        }
    }

    private static class TeacherComparator implements Comparator<Teacher> {
        @Override
        public int compare(Teacher o1, Teacher o2) {
            if(o1.getTaskNum() > o2.getTaskNum()) {
                return 1;
            } else if(o1.getTaskNum() < o2.getTaskNum()) {
                return -1;
            }
            return 0;
        }
    }

    private static class WorkGroupTask {
        private Integer workGroupId;
        /**组别的数目**/
        private Integer taskNum;
        private PriorityQueue<Teacher> teacherPriorityQueue;

        public PriorityQueue<Teacher> getTeacherPriorityQueue() {
            return teacherPriorityQueue;
        }

        public void setTeacherPriorityQueue(PriorityQueue<Teacher> teacherPriorityQueue) {
            this.teacherPriorityQueue = teacherPriorityQueue;
        }

        public Integer getWorkGroupId() {
            return workGroupId;
        }

        public void setWorkGroupId(Integer workGroupId) {
            this.workGroupId = workGroupId;
        }

        public Integer getTaskNum() {
            return taskNum;
        }

        public void setTaskNum(Integer taskNum) {
            this.taskNum = taskNum;
        }
    }

    private static class Teacher{
        private Integer workGroupId;
        private Integer teacherId;
        private Integer taskNum;


        public Integer getWorkGroupId() {
            return workGroupId;
        }

        public void setWorkGroupId(Integer workGroupId) {
            this.workGroupId = workGroupId;
        }

        public Integer getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(Integer teacherId) {
            this.teacherId = teacherId;
        }

        public Integer getTaskNum() {
            return taskNum;
        }

        public void setTaskNum(Integer taskNum) {
            this.taskNum = taskNum;
        }
    }


    public static void main(String[] args) {
        PriorityQueue<WorkGroupTask> workGroupTasks = new PriorityQueue<>(5,new WorkGroupComparator());
        for(int i=0; i<5;i++) {
            WorkGroupTask workGroupTask = new WorkGroupTask();
            workGroupTask.setWorkGroupId(i);
            workGroupTask.setTaskNum(i);
            PriorityQueue<Teacher> teacherPriorityQueue = new PriorityQueue<>();
            for(int j=5; j<10; j++) {
                //构建老师队列
                Teacher teacher = new Teacher();
                teacher.setTaskNum(j);
                teacher.setTeacherId(j);
                teacher.setWorkGroupId(i);
            }
            workGroupTask.setTeacherPriorityQueue(teacherPriorityQueue);
            workGroupTasks.add(workGroupTask);
        }
        int taskNum = 5;
        while (taskNum != 0) {
            WorkGroupTask workGroupTask = workGroupTasks.poll();
            //处理完逻辑
            workGroupTask.setTaskNum(workGroupTask.getTaskNum() + 1);
            workGroupTasks.add(workGroupTask);
            --taskNum;
        }
        while (workGroupTasks.size()!= 0 ) {
            System.out.println(workGroupTasks.remove().getTaskNum());
        }
    }
}
