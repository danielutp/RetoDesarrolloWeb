package com.sofka.tareas;
import com.sofka.tareas.domain.SubTarea;
import com.sofka.tareas.domain.Tarea;
import com.sofka.tareas.repository.SubTareaRepository;
import com.sofka.tareas.service.SubTareaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TareasApplicationTests {


	@Test
	void contextLoads() {
	}

	@Autowired
	SubTareaRepository subTareaRepository;
	@Test
    public void testGuardarRoles() {
		Long idTarea = 1L;
		Tarea tarea = new Tarea();
        SubTarea subTarea = new SubTarea(2L,"vendedor",false,tarea);
		SubTarea subTarea1 = SubTareaRepository.save(subTarea, idTarea);
        assertNotNull(subTarea1);
    }

}
