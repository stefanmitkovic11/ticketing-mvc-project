package company.service.impl;

import company.dto.TaskDTO;
import company.enums.Status;
import company.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, String> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO object) {
        if(object.getTaskStatus() == null) {
            object.setTaskStatus(Status.OPEN);
        }
        super.save(object.getTaskSubject(), object);
        return object;
    }

    @Override
    public TaskDTO findById(String subject) {
        return super.findById(subject);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDTO object) {
        if (object.getTaskStatus() == null) {
            object.setTaskStatus(findById(object.getTaskSubject()).getTaskStatus());
        }
        super.update(object.getTaskSubject(),object);
    }

    @Override
    public void deleteById(String subject) {
        super.deleteById(subject);
    }
}
