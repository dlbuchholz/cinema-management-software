/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.CinemaManagementSoftwarePackage;
import cinemaManagementSoftware.Seat;
import cinemaManagementSoftware.SeatingRow;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Seat</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.impl.SeatImpl#getRow <em>Row</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.SeatImpl#getId <em>Id</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.SeatImpl#getSeatNumber <em>Seat Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SeatImpl extends MinimalEObjectImpl.Container implements Seat {
	/**
	 * The cached value of the '{@link #getRow() <em>Row</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRow()
	 * @generated
	 * @ordered
	 */
	protected SeatingRow row;

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
	 * The default value of the '{@link #getSeatNumber() <em>Seat Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeatNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int SEAT_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeatNumber() <em>Seat Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeatNumber()
	 * @generated
	 * @ordered
	 */
	protected int seatNumber = SEAT_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeatImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinemaManagementSoftwarePackage.Literals.SEAT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SeatingRow getRow() {
		if (row != null && row.eIsProxy()) {
			InternalEObject oldRow = (InternalEObject) row;
			row = (SeatingRow) eResolveProxy(oldRow);
			if (row != oldRow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CinemaManagementSoftwarePackage.SEAT__ROW, oldRow,
							row));
			}
		}
		return row;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeatingRow basicGetRow() {
		return row;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRow(SeatingRow newRow,
			NotificationChain msgs) {
		SeatingRow oldRow = row;
		row = newRow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, CinemaManagementSoftwarePackage.SEAT__ROW,
					oldRow, newRow);
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
	public void setRow(SeatingRow newRow) {
		if (newRow != row) {
			NotificationChain msgs = null;
			if (row != null)
				msgs = ((InternalEObject) row).eInverseRemove(this,
						CinemaManagementSoftwarePackage.SEATING_ROW__SEATS,
						SeatingRow.class, msgs);
			if (newRow != null)
				msgs = ((InternalEObject) newRow).eInverseAdd(this,
						CinemaManagementSoftwarePackage.SEATING_ROW__SEATS,
						SeatingRow.class, msgs);
			msgs = basicSetRow(newRow, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.SEAT__ROW, newRow, newRow));
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
					CinemaManagementSoftwarePackage.SEAT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSeatNumber() {
		return seatNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSeatNumber(int newSeatNumber) {
		int oldSeatNumber = seatNumber;
		seatNumber = newSeatNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.SEAT__SEAT_NUMBER,
					oldSeatNumber, seatNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.SEAT__ROW:
			if (row != null)
				msgs = ((InternalEObject) row).eInverseRemove(this,
						CinemaManagementSoftwarePackage.SEATING_ROW__SEATS,
						SeatingRow.class, msgs);
			return basicSetRow((SeatingRow) otherEnd, msgs);
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
		case CinemaManagementSoftwarePackage.SEAT__ROW:
			return basicSetRow(null, msgs);
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
		case CinemaManagementSoftwarePackage.SEAT__ROW:
			if (resolve)
				return getRow();
			return basicGetRow();
		case CinemaManagementSoftwarePackage.SEAT__ID:
			return getId();
		case CinemaManagementSoftwarePackage.SEAT__SEAT_NUMBER:
			return getSeatNumber();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.SEAT__ROW:
			setRow((SeatingRow) newValue);
			return;
		case CinemaManagementSoftwarePackage.SEAT__ID:
			setId((Integer) newValue);
			return;
		case CinemaManagementSoftwarePackage.SEAT__SEAT_NUMBER:
			setSeatNumber((Integer) newValue);
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
		case CinemaManagementSoftwarePackage.SEAT__ROW:
			setRow((SeatingRow) null);
			return;
		case CinemaManagementSoftwarePackage.SEAT__ID:
			setId(ID_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.SEAT__SEAT_NUMBER:
			setSeatNumber(SEAT_NUMBER_EDEFAULT);
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
		case CinemaManagementSoftwarePackage.SEAT__ROW:
			return row != null;
		case CinemaManagementSoftwarePackage.SEAT__ID:
			return id != ID_EDEFAULT;
		case CinemaManagementSoftwarePackage.SEAT__SEAT_NUMBER:
			return seatNumber != SEAT_NUMBER_EDEFAULT;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", seatNumber: ");
		result.append(seatNumber);
		result.append(')');
		return result.toString();
	}

} //SeatImpl
