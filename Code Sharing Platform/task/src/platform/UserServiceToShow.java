package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceToShow {
    private final DBRepositoryNoRestrictions dbRepositoryNoRestrictions;

    @Autowired
    public UserServiceToShow(DBRepositoryNoRestrictions dbRepositoryNoRestrictions) {
        this.dbRepositoryNoRestrictions = dbRepositoryNoRestrictions;
    }

    public void delete(Code code) {
        dbRepositoryNoRestrictions.delete(code);
    }

    public void deleteById(Long ID) {
        dbRepositoryNoRestrictions.deleteById(ID);
    }

    public Code save(Code code) {
        return dbRepositoryNoRestrictions.save(code);
    }

    public Code findCodeById(Long ID) {
        return dbRepositoryNoRestrictions.findById(ID).get();
    }

    public long count() {
        return dbRepositoryNoRestrictions.count();
    }


}
