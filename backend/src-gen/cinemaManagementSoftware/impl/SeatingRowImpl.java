/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.Category;
import cinemaManagementSoftware.CinemaHall;
import cinemaManagementSoftware.CinemaManagementSoftwarePackage;
import cinemaManagementSoftware.Seat;
import cinemaManagementSoftware.SeatingRow;

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
 * An implementation of the model object '<em><b>Seating Row</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.impl.SeatingRowImpl#getCinemahall <em>Cinemahall</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.SeatingRowImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.SeatingRowImpl#getSeats <em>Seats</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.SeatingRowImpl#getId <em>Id</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.SeatingRowImpl#getRowNr <em>Row Nr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SeatingRowImpl extends MinimalEObjectImpl.Container
		implements SeatingRow {
	/**
	 * The cached value of the '{@link #getCinemahall() <em>Cinemahall</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCinemahall()
	 * @generated
	 * @ordered
	 */
	protected CinemaHall cinemahall;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final Category CATEGORY_EDEFAULT = Category.PARQUET;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected Category category = CATEGORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSeats() <em>Seats</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeats()
	 * @generated
	 * @ordered
	 */
	protected EList<Seat> seats;

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
	 * The default value of the '{@link #getRowNr() <em>Row Nr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRowNr()
	 * @generated
	 * @ordered
	 */
	protected static final int ROW_NR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRowNr() <em>Row Nr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRowNr()
	 * @generated
	 * @ordered
	 */
	protected int rowNr = ROW_NR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeatingRowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinemaManagementSoftwarePackage.Literals.SEATING_ROW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CinemaHall getCinemahall() {
		if (cinemahall != null && cinemahall.eIsProxy()) {
			InternalEObject oldCinemahall = (InternalEObject) cinemahall;
			cinemahall = (CinemaHall) eResolveProxy(oldCinemahall);
			if (cinemahall != oldCinemahall) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CinemaManagementSoftwarePackage.SEATING_ROW__CINEMAHALL,
							oldCinemahall, cinemahall));
			}
		}
		return cinemahall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CinemaHall basicGetCinemahall() {
		return cinemahall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCinemahall(CinemaHall newCinemahall,
			NotificationChain msgs) {
		CinemaHall oldCinemahall = cinemahall;
		cinemahall = newCinemahall;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					CinemaManagementSoftwarePackage.SEATING_ROW__CINEMAHALL,
					oldCinemahall, newCinemahall);
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
	public void setCinemahall(CinemaHall newCinemahall) {
		if (newCinemahall != cinemahall) {
			NotificationChain msgs = null;
			if (cinemahall != null)
				msgs = ((InternalEObject) cinemahall).eInverseRemove(this,
						CinemaManagementSoftwarePackage.CINEMA_HALL__ROW,
						CinemaHall.class, msgs);
			if (newCinemahall != null)
				msgs = ((InternalEObject) newCinemahall).eInverseAdd(this,
						CinemaManagementSoftwarePackage.CINEMA_HALL__ROW,
						CinemaHall.class, msgs);
			msgs = basicSetCinemahall(newCinemahall, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.SEATING_ROW__CINEMAHALL,
					newCinemahall, newCinemahall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Category getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCategory(Category newCategory) {
		Category oldCategory = category;
		category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.SEATING_ROW__CATEGORY,
					oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Seat> getSeats() {
		if (seats == null) {
			seats = new EObjectWithInverseResolvingEList<Seat>(Seat.class, this,
					CinemaManagementSoftwarePackage.SEATING_ROW__SEATS,
					CinemaManagementSoftwarePackage.SEAT__ROW);
		}
		return seats;
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.SEATING_ROW__ID, oldId,
					id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRowNr() {
		return rowNr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRowNr(int newRowNr) {
		int oldRowNr = rowNr;
		rowNr = newRowNr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.SEATING_ROW__ROW_NR,
					oldRowNr, rowNr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.SEATING_ROW__CINEMAHALL:
			if (cinemahall != null)
				msgs = ((InternalEObject) cinemahall).eInverseRemove(this,
						CinemaManagementSoftwarePackage.CINEMA_HALL__ROW,
						CinemaHall.class, msgs);
			return basicSetCinemahall((CinemaHall) otherEnd, msgs);
		case CinemaManagementSoftwarePackage.SEATING_ROW__SEATS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSeats())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.SEATING_ROW__CINEMAHALL:
			return basicSetCinemahall(null, msgs);
		case CinemaManagementSoftwarePackage.SEATING_ROW__SEATS:
			return ((InternalEList<?>) getSeats()).basicRemove(otherEnd, msgs);
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
		case CinemaManagementSoftwarePackage.SEATING_ROW__CINEMAHALL:
			if (resolve)
				return getCinemahall();
			return basicGetCinemahall();
		case CinemaManagementSoftwarePackage.SEATING_ROW__CATEGORY:
			return getCategory();
		case CinemaManagementSoftwarePackage.SEATING_ROW__SEATS:
			return getSeats();
		case CinemaManagementSoftwarePackage.SEATING_ROW__ID:
			return getId();
		case CinemaManagementSoftwarePackage.SEATING_ROW__ROW_NR:
			return getRowNr();
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
		case CinemaManagementSoftwarePackage.SEATING_ROW__CINEMAHALL:
			setCinemahall((CinemaHall) newValue);
			return;
		case CinemaManagementSoftwarePackage.SEATING_ROW__CATEGORY:
			setCategory((Category) newValue);
			return;
		case CinemaManagementSoftwarePackage.SEATING_ROW__SEATS:
			getSeats().clear();
			getSeats().addAll((Collection<? extends Seat>) newValue);
			return;
		case CinemaManagementSoftwarePackage.SEATING_ROW__ID:
			setId((Integer) newValue);
			return;
		case CinemaManagementSoftwarePackage.SEATING_ROW__ROW_NR:
			setRowNr((Integer) newValue);
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
		case CinemaManagementSoftwarePackage.SEATING_ROW__CINEMAHALL:
			setCinemahall((CinemaHall) null);
			return;
		case CinemaManagementSoftwarePackage.SEATING_ROW__CATEGORY:
			setCategory(CATEGORY_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.SEATING_ROW__SEATS:
			getSeats().clear();
			return;
		case CinemaManagementSoftwarePackage.SEATING_ROW__ID:
			setId(ID_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.SEATING_ROW__ROW_NR:
			setRowNr(ROW_NR_EDEFAULT);
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
		case CinemaManagementSoftwarePackage.SEATING_ROW__CINEMAHALL:
			return cinemahall != null;
		case CinemaManagementSoftwarePackage.SEATING_ROW__CATEGORY:
			return category != CATEGORY_EDEFAULT;
		case CinemaManagementSoftwarePackage.SEATING_ROW__SEATS:
			return seats != null && !seats.isEmpty();
		case CinemaManagementSoftwarePackage.SEATING_ROW__ID:
			return id != ID_EDEFAULT;
		case CinemaManagementSoftwarePackage.SEATING_ROW__ROW_NR:
			return rowNr != ROW_NR_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (category: ");
		result.append(category);
		result.append(", id: ");
		result.append(id);
		result.append(", rowNr: ");
		result.append(rowNr);
		result.append(')');
		return result.toString();
	}

} //SeatingRowImpl
