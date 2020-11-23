package com.tac.fakes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tac.exceptions.IdAlreadyExistException;
import com.tac.exceptions.ObjectNotFoundException;
import com.tac.models.BaseModel;
import com.tac.models.Person;

public abstract class AbstractBD<T> {

	private Long id = 1L;
	private List<T> list = new ArrayList<T>();

	public Person save(T t) {
		validateIfIdAlreadyExist(t);
		((BaseModel) t).setId(id);
		id += 1;
		list.add(t);
		return clone(t);
	}

	protected abstract Person clone(T t);

	public Person update(T t) {
		validateIfIdIsNull(t);
		// get people from list without clone
		T objectToUpdate = getFromBd(t);
		fillObject(t, objectToUpdate);
		// get cloned people from list
		return findById(((BaseModel) t).getId());
	}

	protected abstract void fillObject(T t, T objectToUpdate);

	public void remove(T t) {
		validateIfIdIsNull(t);
		list.remove(t);
	}

	public List<T> getAll() {
		return Collections.unmodifiableList(list);
	}

	public Person findById(Long idToSeach) {
		for (T t : list) {
			if (((BaseModel) t).getId().equals(idToSeach)) {
				return clone(t);
			}
		}
		throw new ObjectNotFoundException("People not found for ID : " + idToSeach);
	}

	private void validateIfIdIsNull(T t) {
		if (((BaseModel) t).getId() == null) {
			throw new ObjectNotFoundException("Object not found in BD");
		}
	}

	private void validateIfIdAlreadyExist(T t) {
		if (((BaseModel) t).getId() != null) {
			throw new IdAlreadyExistException("Object Already have Id");
		}
	}

	public void clearBd() {
		list.clear();
	}

	private T getFromBd(T t) {
		for (T tFromBd : list) {
			if (((BaseModel) t).getId().equals(((BaseModel) tFromBd).getId())) {
				return t;
			}
		}
		throw new ObjectNotFoundException("Object not found in BD");
	}
}
