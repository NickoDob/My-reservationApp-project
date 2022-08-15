import React, {useEffect, useState, useRef} from "react";
import Header from './Header';
import { YMaps, Map, Button, Clusterer } from "react-yandex-maps";
import ItemService from "../services/item.service";
import EventService from "../services/event.service";

const mapState = {
  center: [56.8519, 60.6122],
  controls: ['fullscreenControl', 'typeSelector', 'trafficControl'],
  zoom: 11
};

export default function Maps() {
  const ymaps = useRef(null);
  const placemarkRef = useRef(null);
  const mapRef = useRef([]);
  const [address, setAddress] = useState("");
  const [itemList, setItemList] = useState([]);

    useEffect(() => {
      // Получение данных об Items
      async function getItemData() {
        try {
          const response = await ItemService.getItems();
          const parsedList = response.data && response.data.map((item) => {
            return {
              value: item.id,
              address: `${item.address}`,
              heating: `${item.heating}`,
              square: `${item.square}`,
              price: `${item.price}`
            }
          })
          setItemList(list => [...list, ...parsedList]);
        } catch (err) {
          console.log(err, "API ERROR");
        }
      }
      getItemData();
    }, []);

  const getAddress = () => {
  {itemList.map(point => (
    ymaps.current.geocode(point.address).then((res) => {
      var coord = res.geoObjects.get(0).geometry.getCoordinates();
      placemarkRef.current = new ymaps.current.Placemark(coord,
                                   {iconCaption: "loading.."},
                                   {preset: "islands#violetDotIconWithCaption"}
                                 );
      mapRef.current.geoObjects.add(placemarkRef.current);
      placemarkRef.current.properties.set({
        iconCaption: point.address,
        balloonContentHeader: point.address,
        balloonContentBody:
            '<b>Отопление:</b><br/>'+point.heating+'<br/><b>Площадь(м2):</b><br/>'+point.square+'<br/><b>Стоимость(руб./сут.):</b><br/>'+point.price,
      });
    })
    ))}
  };

  const clearAll = () => {
      mapRef.current.geoObjects.removeAll();
    }

  return (
    <div>
    <Header/>
      <YMaps
        query={{ apikey: "802629a7-3b48-4da5-824e-88f0ea31e1b5", load: "package.full" }}
        >
        <Map
          width='100%'
          height='500px'
          modules={["Placemark", "geocode", "geoObject.addon.balloon"]}
          instanceRef={mapRef}
          onLoad={(ympasInstance) => (ymaps.current = ympasInstance)}
          state={mapState}
          >
          <Button onClick={clearAll} data={{ content: 'Очистить' }} options={{ float: 'right', maxWidth: 150 }} />
          <Button onClick={getAddress} data={{ content: 'Отобразить' }} options={{ float: 'right', maxWidth: 150 }} />
        </Map>
      </YMaps>
    </div>
  );
}
