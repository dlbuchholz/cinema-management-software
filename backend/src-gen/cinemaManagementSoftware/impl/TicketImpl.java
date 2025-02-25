/**
 */
package cinemaManagementSoftware.impl;

import cinemaManagementSoftware.CinemaManagementSoftwarePackage;
import cinemaManagementSoftware.Screening;
import cinemaManagementSoftware.Seat;
import cinemaManagementSoftware.Ticket;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.eclipse.emf.common.notify.Notification;

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
 * </ul>
 *
 * @generated
 */
@Entity
@Table(name = "tickets")
public class TicketImpl extends MinimalEObjectImpl.Container implements Ticket {
	/**
	 * The cached value of the '{@link #getScreening() <em>Screening</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScreening()
	 * @generated
	 * @ordered
	 */
	@ManyToOne(targetEntity = ScreeningImpl.class)
    @JoinColumn(name = "screening_id", nullable = false)
	protected Screening screening;

	/**
	 * The cached value of the '{@link #getSeat() <em>Seat</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeat()
	 * @generated
	 * @ordered
	 */
	@ManyToOne(targetEntity = SeatImpl.class)
    @JoinColumn(name = "seat_id", nullable = false)
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
	@Column(nullable = false)
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
	@Column(name = "is_booked", nullable = false)
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
	@Id
    @Column(name = "id", nullable = false, updatable = false)
	protected int id = ID_EDEFAULT;

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
							CinemaManagementSoftwarePackage.TICKET__SCREENING,
							oldScreening, screening));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.TICKET__SCREENING,
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
							CinemaManagementSoftwarePackage.TICKET__SEAT,
							oldSeat, seat));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.TICKET__SEAT, oldSeat,
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.TICKET__PRICE, oldPrice,
					price));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.TICKET__IS_BOOKED,
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					CinemaManagementSoftwarePackage.TICKET__ID, oldId, id));
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
