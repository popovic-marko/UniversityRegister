package rs.ac.bg.fon.silab.ru.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.ru.dao.GenericDAO;
import rs.ac.bg.fon.silab.ru.domain.ContactType;
import rs.ac.bg.fon.silab.ru.domain.IDomain;
import rs.ac.bg.fon.silab.ru.dto.ContactTypeDTO;
import rs.ac.bg.fon.silab.ru.mapper.ContactTypeMapper;

/**
 *
 * @author user
 */
@Service
public class ContactService {
    @Autowired
    GenericDAO genericDao;

    public List<ContactTypeDTO> getAllContactTypes() throws Exception{
        List<IDomain> result = genericDao.findAll(new ContactType());
        List<ContactTypeDTO> contactTypes = new LinkedList<>();
        for (IDomain item : result) {
            ContactType contactType = (ContactType) item;
            ContactTypeDTO contactTypeDTO = ContactTypeMapper.INSTANCE.contactTypeToContactTypeDTO(contactType);
            contactTypes.add(contactTypeDTO);
        }
        
        return contactTypes;
    }
}
