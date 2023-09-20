package com.objecteffects.contactlist.view;

import java.io.IOException;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.objecteffects.contactlist.model.Contact;
import com.objecteffects.contactlist.service.ContactService;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ContactView implements Serializable {
    private static final long serialVersionUID = 4694088548123087426L;

    private Logger log;
    private Long id;
    private Contact contact;

    @Inject
    private ContactService contactService;
    @Inject
    private ExternalContext externalContext;

    @PostConstruct
    public void init() {
        this.log = LoggerFactory.getLogger(ContactView.class);
    }

    public Long getId() {
        this.log.info("get contactId");

        return this.id;
    }

    public void setId(final Long _id) {
        this.log.info("set id, {}", _id);

        this.id = _id;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(final Contact _contact) {
        this.contact = _contact;
    }

    public void submit(final Long _id) throws IOException {
        this.log.info("submit, id={}", _id);

        this.id = _id;

        this.contact = this.contactService.getContact(this.id);

        this.externalContext.redirect("contact.xhtml");
    }
}
