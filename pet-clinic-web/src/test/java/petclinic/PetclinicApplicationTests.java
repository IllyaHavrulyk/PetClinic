package petclinic;

import com.havrulyk.petclinic.PetclinicApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PetclinicApplication.class)
class PetclinicApplicationTests {

  @Test
  void contextLoads() {
  }

}
