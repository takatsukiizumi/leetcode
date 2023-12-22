package takatsukiizumi.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentBuilder;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.idm.api.User;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/5/29
 */

public class FlowAbleTest {


    ProcessEngineConfiguration configuration;

    @Before
    //环境初始化
    public void Before() {
        //获取配置对象
        configuration = new StandaloneProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("root");
        configuration.setJdbcUrl("jdbc:mysql://192.168.1.126:3306/aqglxt-cs?characterEncoding=UTF-8&useUnicode=true&useSSL=false&tinyInt1isBit=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true");
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
    }


    @Test
    //部署流程
    public void testDeploy() {
        ProcessEngine processEngine = configuration.buildProcessEngine();
        RepositoryService service = processEngine.getRepositoryService();
        Deployment deployment = service.createDeployment()
                .addClasspathResource("holiday-request.bpmn20.xml")
                .name("请假流程")
                .deploy();
        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }


    @Test
    //启动一个流程实例
    public void testRunProcess() {
        ProcessEngine processEngine = configuration.buildProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", "user1");
        variables.put("nrOfHolidays", "3");
        variables.put("description", "描述");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayRequest", variables);
        System.out.println(processInstance.getProcessDefinitionId());
        System.out.println(processInstance.getId());
        System.out.println(processInstance.getActivityId());
    }


    @Test
    //查询特定流程实例中有哪些任务
    public void testQuery() {
        ProcessEngine processEngine = configuration.buildProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //这里的10001 就是 processInstance.getId() ,一个流程实例里可能有多个任务
        TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId("52501");
        List<Task> tasks = taskQuery.list();
        System.out.println("You have " + tasks.size() + " tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ") " + tasks.get(i).getName());
            System.out.println((i + 1) + ") " + tasks.get(i).getId());
            System.out.println((i + 1) + ") " + tasks.get(i).getDescription());
        }
    }


    @Test
    //查询任务分配的人员范围
    public void queryTask() {
        ProcessEngine processEngine = configuration.buildProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        String taskId = "10008";
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String assigneeUserId = task.getAssignee();
        System.out.println(assigneeUserId);
        //如果assigneeUserId的值为空代表，该任务是一个候选任务，可以认领完成。
    }


    @Test
    //认领任务，完成任务。
    public void testCompleteTask() {
        ProcessEngine processEngine = configuration.buildProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        String taskId = "52508";
        String userId = "user1";
        //指定某人认领任务
        //taskService.claim(taskId, userId);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", true);
        taskService.complete(taskId,variables);
    }

    @Test
    //查询这条流程实例的历史记录
    public void testqueryHistory(){
        ProcessEngine processEngine = configuration.buildProcessEngine();
        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> activities =
                historyService.createHistoricActivityInstanceQuery()
                        .processInstanceId("52501")
                        .finished()
                        .orderByHistoricActivityInstanceEndTime().asc()
                        .list();
        for (HistoricActivityInstance activity : activities) {
            System.out.println(activity.getActivityId() + " took "
                    + activity.getDurationInMillis() + " milliseconds");
        }

    }
    @Test
    //查询firstName叫john的人
    public void findPerson(){
        ProcessEngine processEngine = configuration.buildProcessEngine();
        IdentityService identityService = processEngine.getIdentityService();
       // User john = identityService.createUserQuery().userFirstName("john").singleResult();
        List<User> john = identityService.createUserQuery().userFirstName("john").list();
        john.forEach(x -> System.out.println(x.getEmail()));
    }





    }
