/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.CinemaManagementSoftwarePackage;
import cinemaManagementSoftware.Customer;
import cinemaManagementSoftware.Screening;
import cinemaManagementSoftware.Seat;
import cinemaManagementSoftware.Ticket;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ticket</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cinemaManagementSoftware.impl.TicketImpl#getScreening <em>Screening</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.TicketImpl#getSeat <em>Seat</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.TicketImpl#getPrice <em>Price</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.TicketImpl#isIsBooked <em>Is Booked</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.TicketImpl#getId <em>Id</em>}</li>
 *   <li>{@link cinemaManagementSoftware.impl.TicketImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TicketImpl extends MinimalEObjectImpl.Container implements Ticket {
	/**
	 * The cached value of the '{@link #getScreening() <em>Screening</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScreening()
	 * @generated
	 * @ordered
	 */
	protected Screening screening;

	/**
	 * The cached value of the '{@link #getSeat() <em>Seat</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeat()
	 * @generated
	 * @ordered
	 */
	protected Seat seat;

	/**
	 * The default value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected static final double PRICE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected double price = PRICE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsBooked() <em>Is Booked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBooked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BOOKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsBooked() <em>Is Booked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBooked()
	 * @generated
	 * @ordered
	 */
	protected boolean isBooked = IS_BOOKED_EDEFAULT;

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
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected Customer owner;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TicketImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinemaManagementSoftwarePackage.Literals.TICKET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Screening getScreening() {
		if (screening != null && screening.eIsProxy()) {
			InternalEObject oldScreening = (InternalEObject) screening;
			screening = (Screening) eResolveProxy(oldScreening);
			if (screening != oldScreening) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CinemaManagementSoftwarePackage.TICKET__SCREENING, oldScreening, screening));
			}
		}
		return screening;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Screening basicGetScreening() {
		return screening;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScreening(Screening newScreening) {
		Screening oldScreening = screening;
		screening = newScreening;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.TICKET__SCREENING,
					oldScreening, screening));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Seat getSeat() {
		if (seat != null && seat.eIsProxy()) {
			InternalEObject oldSeat = (InternalEObject) seat;
			seat = (Seat) eResolveProxy(oldSeat);
			if (seat != oldSeat) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CinemaManagementSoftwarePackage.TICKET__SEAT, oldSeat, seat));
			}
		}
		return seat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seat basicGetSeat() {
		return seat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSeat(Seat newSeat) {
		Seat oldSeat = seat;
		seat = newSeat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.TICKET__SEAT, oldSeat,
					seat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPrice() {
		return price;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrice(double newPrice) {
		double oldPrice = price;
		price = newPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.TICKET__PRICE,
					oldPrice, price));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsBooked() {
		return isBooked;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsBooked(boolean newIsBooked) {
		boolean oldIsBooked = isBooked;
		isBooked = newIsBooked;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.TICKET__IS_BOOKED,
					oldIsBooked, isBooked));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.TICKET__ID, oldId,
					id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Customer getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject) owner;
			owner = (Customer) eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CinemaManagementSoftwarePackage.TICKET__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Customer newOwner, NotificationChain msgs) {
		Customer oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.TICKET__OWNER, oldOwner, newOwner);
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
	public void setOwner(Customer newOwner) {
		if (newOwner != owner) {
			NotificationChain msgs = null;
			if (owner != null)
				msgs = ((InternalEObject) owner).eInverseRemove(this, CinemaManagementSoftwarePackage.CUSTOMER__TICKET,
						Customer.class, msgs);
			if (newOwner != null)
				msgs = ((InternalEObject) newOwner).eInverseAdd(this, CinemaManagementSoftwarePackage.CUSTOMER__TICKET,
						Customer.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CinemaManagementSoftwarePackage.TICKET__OWNER,
					newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CinemaManagementSoftwarePackage.TICKET__OWNER:
			if (owner != null)
				msgs = ((InternalEObject) owner).eInverseRemove(this, CinemaManagementSoftwarePackage.CUSTOMER__TICKET,
						Customer.class, msgs);
			return basicSetOwner((Customer) otherEnd, msgs);
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
		case CinemaManagementSoftwarePackage.TICKET__OWNER:
			return basicSetOwner(null, msgs);
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
		case CinemaManagementSoftwarePackage.TICKET__SCREENING:
			if (resolve)
				return getScreening();
			return basicGetScreening();
		case CinemaManagementSoftwarePackage.TICKET__SEAT:
			if (resolve)
				return getSeat();
			return basicGetSeat();
		case CinemaManagementSoftwarePackage.TICKET__PRICE:
			return getPrice();
		case CinemaManagementSoftwarePackage.TICKET__IS_BOOKED:
			return isIsBooked();
		case CinemaManagementSoftwarePackage.TICKET__ID:
			return getId();
		case CinemaManagementSoftwarePackage.TICKET__OWNER:
			if (resolve)
				return getOwner();
			return basicGetOwner();
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
		case CinemaManagementSoftwarePackage.TICKET__SCREENING:
			setScreening((Screening) newValue);
			return;
		case CinemaManagementSoftwarePackage.TICKET__SEAT:
			setSeat((Seat) newValue);
			return;
		case CinemaManagementSoftwarePackage.TICKET__PRICE:
			setPrice((Double) newValue);
			return;
		case CinemaManagementSoftwarePackage.TICKET__IS_BOOKED:
			setIsBooked((Boolean) newValue);
			return;
		case CinemaManagementSoftwarePackage.TICKET__ID:
			setId((Integer) newValue);
			return;
		case CinemaManagementSoftwarePackage.TICKET__OWNER:
			setOwner((Customer) newValue);
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
		case CinemaManagementSoftwarePackage.TICKET__SCREENING:
			setScreening((Screening) null);
			return;
		case CinemaManagementSoftwarePackage.TICKET__SEAT:
			setSeat((Seat) null);
			return;
		case CinemaManagementSoftwarePackage.TICKET__PRICE:
			setPrice(PRICE_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.TICKET__IS_BOOKED:
			setIsBooked(IS_BOOKED_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.TICKET__ID:
			setId(ID_EDEFAULT);
			return;
		case CinemaManagementSoftwarePackage.TICKET__OWNER:
			setOwner((Customer) null);
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
		case CinemaManagementSoftwarePackage.TICKET__SCREENING:
			return screening != null;
		case CinemaManagementSoftwarePackage.TICKET__SEAT:
			return seat != null;
		case CinemaManagementSoftwarePackage.TICKET__PRICE:
			return price != PRICE_EDEFAULT;
		case CinemaManagementSoftwarePackage.TICKET__IS_BOOKED:
			return isBooked != IS_BOOKED_EDEFAULT;
		case CinemaManagementSoftwarePackage.TICKET__ID:
			return id != ID_EDEFAULT;
		case CinemaManagementSoftwarePackage.TICKET__OWNER:
			return owner != null;
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
		result.append(" (price: ");
		result.append(price);
		result.append(", isBooked: ");
		result.append(isBooked);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //TicketImpl
