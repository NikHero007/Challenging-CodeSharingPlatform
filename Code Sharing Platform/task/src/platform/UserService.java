package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final DBRepository dbRepository;

    @Autowired
    public UserService(DBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public void delete(Code code) {
        dbRepository.delete(code);
    }

    public void deleteById(Long ID) {
        dbRepository.deleteById(ID);
    }

    public Code save(Code code) {
        return dbRepository.save(code);
    }

    public Code findCodeById(Long ID) {
        return dbRepository.findById(ID).get();
    }

    public long count() {
        return dbRepository.count();
    }


}
