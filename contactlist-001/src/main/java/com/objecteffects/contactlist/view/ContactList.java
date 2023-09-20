package com.objecteffects.contactlist.view;

import java.io.Serializable;
import java.util.List;

import com.objecteffects.contactlist.model.Contact;
import com.objecteffects.contactlist.service.ContactService;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ContactList implements Serializable {
    private static final long serialVersionUID = -570500230181100578L;

    private List<Contact> contacts;

    @Inject
    private ContactService contactService;

    @PostConstruct
    public void init() {
        this.contacts = this.contactService.list();
    }

    public List<Contact> getContacts() {
        return this.contacts;
    }

    public Contact getContact(final Long id) {
        return this.contactService.getContact(id);
    }

    public void submit() {
        // nothing
    }
}
