/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.Cinema;
import cinemaManagementSoftware.CinemaHall;
import cinemaManagementSoftware.CinemaManagementSoftwarePackage;
import cinemaManagementSoftware.SeatingRow;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cinema Hall</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.impl.CinemaHallImpl#getRow <em>Row</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.CinemaHallImpl#getId <em>Id</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.CinemaHallImpl#getName <em>Name</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.CinemaHallImpl#getCinema <em>Cinema</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CinemaHallImpl extends MinimalEObjectImpl.Container implements CinemaHall {
	/**
	 * The cached value of the '{@link #getRow() <em>Row</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRow()
	 * @generated
	 * @ordered
	 */
	protected EList<SeatingRow> row;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCinema() <em>Cinema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCinema()
	 * @generated
	 * @ordered
	 */
	protected Cinema cinema;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CinemaHallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinemaManagementSoftwarePackage.Literals.CINEMA_HALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SeatingRow> getRow() {
		if (row == null) {
			row = new EObjectWithInverseResolvingEList<SeatingRow>(SeatingRow.class, this,
					CinemaManagementSoftwarePackage.CINEMA_HALL__ROW,
					CinemaManagementSoftwarePackage.SEATING_ROW__CINEMAHALL);
		}
		return row;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.CINEMA_HALL__ID,
					oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.CINEMA_HALL__NAME,
					oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Cinema getCinema() {
		if (cinema != null && cinema.eIsProxy()) {
			InternalEObject oldCinema = (InternalEObject) cinema;
			cinema = (Cinema) eResolveProxy(oldCinema);
			if (cinema != oldCinema) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CinemaManagementSoftwarePackage.CINEMA_HALL__CINEMA, oldCinema, cinema));
			}
		}
		return cinema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cinema basicGetCinema() {
		return cinema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCinema(Cinema newCinema, NotificationChain msgs) {
		Cinema oldCinema = cinema;
		cinema = newCinema;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.CINEMA_HALL__CINEMA, oldCinema, newCinema);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCinema(Cinema newCinema) {
		if (newCinema != cinema) {
			NotificationChain msgs = null;
			if (cinema != null)
				msgs = ((InternalEObject) cinema).eInverseRemove(this, CinemaManagementSoftwarePackage.CINEMA__HALL,
						Cinema.class, msgs);
			if (newCinema != null)
				msgs = ((InternalEObject) newCinema).eInverseAdd(this, CinemaManagementSoftwarePackage.CINEMA__HALL,
						Cinema.class, msgs);
			msgs = basicSetCinema(newCinema, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.CINEMA_HALL__CINEMA,
					newCinema, newCinema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void isConfigComplete() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.CINEMA_HALL__ROW:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRow()).basicAdd(otherEnd, msgs);
		case CinemaManagementSoftwarePackage.CINEMA_HALL__CINEMA:
			if (cinema != null)
				msgs = ((InternalEObject) cinema).eInverseRemove(this, CinemaManagementSoftwarePackage.CINEMA__HALL,
						Cinema.class, msgs);
			return basicSetCinema((Cinema) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.CINEMA_HALL__ROW:
			return ((InternalEList<?>) getRow()).basicRemove(otherEnd, msgs);
		case CinemaManagementSoftwarePackage.CINEMA_HALL__CINEMA:
			return basicSetCinema(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.CINEMA_HALL__ROW:
			return getRow();
		case CinemaManagementSoftwarePackage.CINEMA_HALL__ID:
			return getId();
		case CinemaManagementSoftwarePackage.CINEMA_HALL__NAME:
			return getName();
		case CinemaManagementSoftwarePackage.CINEMA_HALL__CINEMA:
			if (resolve)
				return getCinema();
			return basicGetCinema();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.CINEMA_HALL__ROW:
			getRow().clear();
			getRow().addAll((Collection<? extends SeatingRow>) newValue);
			return;
		case CinemaManagementSoftwarePackage.CINEMA_HALL__ID:
			setId((Integer) newValue);
			return;
		case CinemaManagementSoftwarePackage.CINEMA_HALL__NAME:
			setName((String) newValue);
			return;
		case CinemaManagementSoftwarePackage.CINEMA_HALL__CINEMA:
			setCinema((Cinema) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.CINEMA_HALL__ROW:
			getRow().clear();
			return;
		case CinemaManagementSoftwarePackage.CINEMA_HALL__ID:
			setId(ID_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.CINEMA_HALL__NAME:
			setName(NAME_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.CINEMA_HALL__CINEMA:
			setCinema((Cinema) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.CINEMA_HALL__ROW:
			return row != null && !row.isEmpty();
		case CinemaManagementSoftwarePackage.CINEMA_HALL__ID:
			return id != ID_EDEFAULT;
		case CinemaManagementSoftwarePackage.CINEMA_HALL__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case CinemaManagementSoftwarePackage.CINEMA_HALL__CINEMA:
			return cinema != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case CinemaManagementSoftwarePackage.CINEMA_HALL___IS_CONFIG_COMPLETE:
			isConfigComplete();
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //CinemaHallImpl
