package com.addressbook.app.services;

import com.addressbook.app.entity.Contact;
import com.addressbook.app.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public void addContact(Contact contact) {
		contactRepository.save(contact);
	}
	
	public Contact editContact(Contact update) {

	    Contact contact = contactRepository.findById(update.getId())
	            .orElseThrow(() -> new RuntimeException("Contact not found with id: " + update.getId()));

	    contact.setFirstName(update.getFirstName());
	    contact.setLastName(update.getLastName());
	    contact.setAddress(update.getAddress());
	    contact.setCity(update.getCity());
	    contact.setState(update.getState());
	    contact.setZip(update.getZip());
	    contact.setPhone(update.getPhone());
	    contact.setEmail(update.getEmail());

	    return contactRepository.save(contact);
	}

    public void deleteById(Long id){
        contactRepository.deleteById(id);
    }
	
	public Iterable<Contact> getAll() {
		return contactRepository.findAll();
	}


}
