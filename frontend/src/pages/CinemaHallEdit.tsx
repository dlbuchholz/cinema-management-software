import React, { useEffect, useState } from 'react';
import { Card, Row, Col, Typography } from 'antd';
import { useNavigate } from 'react-router-dom';
import cinemaHallService from '../services/cinemaService';
import { CinemaHall } from '../types';
const { Title } = Typography;

const CinemaHallEdit: React.FC = () => {
  const [halls, setHalls] = useState<CinemaHall[]>([]);
  const navigate = useNavigate();

  useEffect(() => {
    cinemaHallService.getHalls().then(data => setHalls(data));
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <Title level={3}>Filmsaal bearbeiten</Title>
      <Row gutter={[16, 16]}>
        {halls.map(hall => (
          <Col key={hall.id} xs={24} sm={12} md={8} lg={6}>
            <Card
              hoverable
              title={hall.name}
              onClick={() => navigate(`/account/saal/${hall.id}`)}
            >
              <p>Total Seats: {hall.totalSeats}</p>
              <p>Rows: {hall.rows}</p>
            </Card>
          </Col>
        ))}
      </Row>
    </div>
  );
};

export default CinemaHallEdit;
