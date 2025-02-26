/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.Cinema;
import cinemaManagementSoftware.CinemaHall;
import cinemaManagementSoftware.CinemaManagementSoftwarePackage;
import cinemaManagementSoftware.CinemaOwner;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cinema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.impl.CinemaImpl#getId <em>Id</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.CinemaImpl#getName <em>Name</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.CinemaImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.CinemaImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.CinemaImpl#getHall <em>Hall</em>}</li>
 * </ul>
 *
 * @generated
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CinemaImpl extends MinimalEObjectImpl.Container implements Cinema, Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	@JsonProperty("id")
	protected long id = ID_EDEFAULT;

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
	@JsonProperty("name")
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	@JsonProperty("location")
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	@JsonProperty("owner")
	protected CinemaOwner owner;

	/**
	 * The cached value of the '{@link #getHall() <em>Hall</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHall()
	 * @generated
	 * @ordered
	 */
	@JsonProperty("hall")
	protected EList<CinemaHall> hall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CinemaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinemaManagementSoftwarePackage.Literals.CINEMA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(long newId) {
		long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.CINEMA__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.CINEMA__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.CINEMA__LOCATION,
					oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CinemaOwner getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject) owner;
			owner = (CinemaOwner) eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CinemaManagementSoftwarePackage.CINEMA__OWNER,
							oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CinemaOwner basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(CinemaOwner newOwner) {
		CinemaOwner oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.CINEMA__OWNER, oldOwner,
					owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CinemaHall> getHall() {
		if (hall == null) {
			hall = new EObjectResolvingEList<CinemaHall>(CinemaHall.class, this,
					CinemaManagementSoftwarePackage.CINEMA__HALL);
		}
		return hall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void totalIncome() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.CINEMA__ID:
			return getId();
		case CinemaManagementSoftwarePackage.CINEMA__NAME:
			return getName();
		case CinemaManagementSoftwarePackage.CINEMA__LOCATION:
			return getLocation();
		case CinemaManagementSoftwarePackage.CINEMA__OWNER:
			if (resolve)
				return getOwner();
			return basicGetOwner();
		case CinemaManagementSoftwarePackage.CINEMA__HALL:
			return getHall();
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
		case CinemaManagementSoftwarePackage.CINEMA__ID:
			setId((Long) newValue);
			return;
		case CinemaManagementSoftwarePackage.CINEMA__NAME:
			setName((String) newValue);
			return;
		case CinemaManagementSoftwarePackage.CINEMA__LOCATION:
			setLocation((String) newValue);
			return;
		case CinemaManagementSoftwarePackage.CINEMA__OWNER:
			setOwner((CinemaOwner) newValue);
			return;
		case CinemaManagementSoftwarePackage.CINEMA__HALL:
			getHall().clear();
			getHall().addAll((Collection<? extends CinemaHall>) newValue);
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
		case CinemaManagementSoftwarePackage.CINEMA__ID:
			setId(ID_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.CINEMA__NAME:
			setName(NAME_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.CINEMA__LOCATION:
			setLocation(LOCATION_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.CINEMA__OWNER:
			setOwner((CinemaOwner) null);
			return;
		case CinemaManagementSoftwarePackage.CINEMA__HALL:
			getHall().clear();
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
		case CinemaManagementSoftwarePackage.CINEMA__ID:
			return id != ID_EDEFAULT;
		case CinemaManagementSoftwarePackage.CINEMA__NAME:
			return NAME_EDEFAULT == null ? name != null
					: !NAME_EDEFAULT.equals(name);
		case CinemaManagementSoftwarePackage.CINEMA__LOCATION:
			return LOCATION_EDEFAULT == null ? location != null
					: !LOCATION_EDEFAULT.equals(location);
		case CinemaManagementSoftwarePackage.CINEMA__OWNER:
			return owner != null;
		case CinemaManagementSoftwarePackage.CINEMA__HALL:
			return hall != null && !hall.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
		case CinemaManagementSoftwarePackage.CINEMA___TOTAL_INCOME:
			totalIncome();
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
		result.append(", location: ");
		result.append(location);
		result.append(')');
		return result.toString();
	}

} //CinemaImpl
